package es.upm.grise.profundizacion.control_1;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LibraryTest {

	Library biblio = new Library();
	/*
	* Se añaden libros correctamente (uno o varios; comprobad la condición de libro repetido).

	 * */
	@Test
	public void libroAñadido() throws DuplicatedBookException, EmptyLibraryException, NonExistingBookException {
		String name = "mavenbook";
		String expected = name;
		Book lib = new Book(name);
		biblio.addBook(lib);
		Book cogido = biblio.getBook(name);
		assertEquals(expected,cogido.getTitle());
	}

	//Se eliminan libros correctamente (comprobar la condición de lista vacía y libro no existente).

	//funciona
	@Test(expected = NonExistingBookException.class)
	public void libroNoExiste() throws DuplicatedBookException, EmptyLibraryException, NonExistingBookException {
		Book libro = new Book("ejemplo");
		biblio.addBook(libro);
		Book libro2 = biblio.getBook("texto");
	}

	//funciona
	@Test(expected = EmptyLibraryException.class)
	public void listaVacia() throws EmptyLibraryException, NonExistingBookException {
		biblio.getBook("inventado");
	}

	@Test
	public void libroEsta() throws DuplicatedBookException, EmptyLibraryException, NonExistingBookException {
		String name = "mavenbook";
		String expected = name;
		Book lib = new Book(name);
		biblio.addBook(lib);
		Book cogido = biblio.getBook(name);
		assertEquals(expected,cogido.getTitle());
	}
}
