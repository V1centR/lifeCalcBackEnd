package com.lifecalc.lifecalcBack;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.lifecalc.lifecalcBack.controller.CategoriaController;
import com.lifecalc.lifecalcBack.entity.Categoria;

public class CategoryInsertsTests {

	@Test
	public void addCategory() {
		
		
		Categoria categoria = new Categoria();
		categoria.setName("SmartPhones");
		
		
		//Integer catController = new CategoriaController().insert(model);
	}
	
	private String[] randomCategory(){
		
		String[] categorias = {""};
		
		
		return categorias;
	}
	
	/**
	 * Filter string to generate email
	 * @param word
	 * @return
	 */
	private String filterStr(String word)
	{
		String FilteredWord = word.
				replaceAll("á|à|â|ã|ä|Á","a").
				replaceAll("é|è|ê|ë","e").
				replaceAll("ó|ò|ô|õ","o").
				replaceAll("ç","c").
				replaceAll("í|ì|ĩ|î","i").
				replaceAll("ú|ü|Ú|Ù|ù|Ü|ũ|Ũ","u");

		return FilteredWord;
	}
	
	
	

}
