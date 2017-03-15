package refactoritzar;

import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Classe GarbellParametresTest()
 * @author Jose Ramon Noguero de Llano
 * @version 1.9
 */
@RunWith(value = Parameterized.class)
public class GarbellParametresTest {
	/**
	 * Retorna els paràmetres
	 * @return params
	 */
		@Parameters
	 public static Collection<Object[]> setParameters() { 
	        
   	  Collection<Object[]> params = new ArrayList<>();

       // Carregarem els paràmetres externs aquí:
       params.add(new Object[] { 20, new int[]{2,3,5,7,11,13,17,19}});
       params.add(new Object[] { 24, new int[]{2,3,5,7,11,15,17,19,23}});
       params.add(new Object[] { 19, new int[]{2,3,5,7,11,13,17,19}});
       params.add(new Object[] { 24, new int[]{2,3,5,7,11,13,17,19,23}});
      
     
       return params;
       }

	// Declaracions 	
		private int max;
		private int[] arrayEsperat;
		/**
		 * Funcio que dona valors a les variables
		 * @param max
		 * @param arrayEsperat
		 */
		public GarbellParametresTest(int max, int[] arrayEsperat)
		{
		   // Afegiu el codi que omplirà els atributs amb el valor dels paràmetres;
			this.max = max;
			this.arrayEsperat=arrayEsperat;
		}
		/**
		 * Funció Test() - Comprova cadasqun dels paràmetres otorgats
		 */
	@Test
	public void test() {

		NombresPrimers g = new NombresPrimers ();
		 int[] result =  NombresPrimers.obtenirPrimers(max);
		 assertArrayEquals(arrayEsperat, result);
	}

}
