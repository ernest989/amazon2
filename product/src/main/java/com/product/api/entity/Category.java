package com.product.api.entity;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;


@Entity
@Table(name="category")
public class Category {

    // Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("category_id")
	@Column(name="category_id")
    private Integer category_id;
	
	@JsonProperty("category")
	@Column(name="category")
    private String category;
	
	@JsonProperty("tag")
	@Column(name="tag")
    private String tag;
	
	@JsonProperty("status")
	@Column(name="status")
    private Integer status;

    // Variables estáticas compartidas
    private static ArrayList<Category> categorias = new ArrayList<>();
    private static Integer ids = 0;
    static Scanner sc = new Scanner(System.in);

    // getters
    public Integer getId() {
        return category_id;
    }

    public String getCategory() {
        return category;
    }

    public String getTag() {
        return tag;
    }

    public Integer getStatus() {
        return status;
    }

    // setters
    public void activar() {
        status = 1;
    }

    public void eliminar() {
        status = 0;
    }

    // constructor
    public Category(int category_id,String category, String tag, int status) {
        this.category_id = category_id;
        this.category = category;
        this.tag = tag;
        this.status = status;
    }
    
    public Category () {}

    @Override
    public String toString() {
        return "{" + getId() + ",\"" + getCategory() + "\",\"" + getTag() + "\"," + getStatus() + "}";
    }

    // imprime las categorias activas
    public static void getCategories() {
        System.out.print("[");
        for (Category c : categorias) {
            if (c.getStatus() == 1) {
                System.out.print(c + ","); 
            }
        }
        System.out.println("]");
    }

    // elimina una categoria
    public static void deleteCategory(int id) {
        if (id < 0 || id >= categorias.size()) {
            System.out.println("Id inválido");
        } else {
            categorias.get(id).eliminar();
            System.out.println("Categoria: " + categorias.get(id) + " eliminada exitosamente");
        }
    }

    // crea categoria o reactiva segun el caso
    public static void createCategory(Category c) {
        categorias.add(c);
        ids++;
        System.out.println("Categoria " + c + " creada.");
    }

    // método auxiliar para saber si un categoría esta ocupada
    public static boolean categoriaOcupada(String cat) {
        for (Category c : categorias) {
            if (c.getCategory().equals(cat)) {
                return true;
            }
        }
        return false;
    }

    // método auxiliar para saber si un tag esta ocupado
    public static boolean tagOcupado(String tag) {
        for (Category c : categorias) {
            if (c.getTag().equals(tag)) {
                return true;
            }
        }
        return false;
    }

    // métodos auxiliares para buscar y regresar una categoría
    public static Category buscarPorNombre(String nom) {
        for (Category c : categorias) {
            if (c.getCategory().equals(nom)) {
                return c;
            }
        }
        return null;
    }

    public static Category buscarPorTag(String tagg) {
        for (Category c : categorias) {
            if (c.getTag().equals(tagg)) {
                return c;
            }
        }
        return null;
    }

    //metodo auxiliar para actualizar una categoria desactivada
    public static void actualizar() {
        ArrayList<Integer> idsValidos = new ArrayList<>();
        System.out.println("Categorias inactivas:");
        System.out.print("[");
        for (Category c : categorias) {
            if (c.getStatus() == 0) {
                idsValidos.add(c.getId());
                System.out.print(c + ",");
            }
        }
        System.out.println("]");
        System.out.println("Ingrese el id de la categoria que quiere actualizar:");
        int actualiza = sc.nextInt();
        if (idsValidos.contains(actualiza)) {
            categorias.get(actualiza).activar();
        }else{
            System.out.println("El id es invalido, intenta de nuevo");
        }
    }

    
}
