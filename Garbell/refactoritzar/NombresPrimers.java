package refactoritzar;

import java.util.Arrays;

// Classe que utilitzarà el garbell d'Erastòtenes per trobar els nombres primers.
// Veure el comportament gràficament aquí de l'algorisme:
// http://blocs.xtec.cat/ceipcirera6/2014/10/08/garbell-derastostenes/


public class NombresPrimers {
	
	/**  
	   * Generar nombres primers de 2 fins a max
	   * @param max es el valor màxim
	   * @return Vector de nombres primers
	   */
	
	public static int[] obtenirPrimers (int max) 
	{   
	     int i,j;
	     if (max >= 2) { 
		    	 
	       // Declaracions
	        int dim = max + 1; 
	
	        // Tamany de l'array
	        boolean[] bEsPrimer = new boolean[dim];     

	        // Inicialitzar l'array
	        i = noumetode1(dim, bEsPrimer); 
	        
	        	// D'entrada eliminem el 0 i l'1, ja que no son nombres primers
	        	bEsPrimer[0] = bEsPrimer[1] = false; 
	
	        	// Garbell d'Erastòtenes: marquem com no primers tots els múltiples dels primers
	        	noumetode(dim, bEsPrimer);
	        
	        	// Quants nombres primers hi ha? Recomptem cada posició a true del array bEsPrimer[]
	        	int comptador = noprimers(dim, bEsPrimer); 
	        
	                // Reomplim el vector posant cada valor de nombre primer en la seva posicio dins el vector
	                int[] VectorPrimers = nopri(dim, bEsPrimer, comptador);     
	                return VectorPrimers; 
	             } else {  // max < 2
	                return new int[0];   // Vector buit
	        } 
	     }


	private static int[] nopri(int dim, boolean[] bEsPrimer, int comptador) {
		int i;
		int j;
		int[] VectorPrimers = new int[comptador];     
		for (i=0, j=0; i<dim; i++) {    
		    if (bEsPrimer[i])
		       VectorPrimers[j++] = i;   
		}
		return VectorPrimers;
	}


	private static int noprimers(int dim, boolean[] bEsPrimer) {
		int i;
		int comptador = 0;   
			for (i=0; i<dim; i++) {   
				if (bEsPrimer[i])   
					comptador++; 
			}
		return comptador;
	}


	private static int noumetode1(int dim, boolean[] bEsPrimer) {
		int i;
		for (i=0; i<dim; i++)    
			bEsPrimer[i] = true;
		return i;
	}


	private static void noumetode(int dim, boolean[] bEsPrimer) {
		int i;
		int j;
		double dim1 = Math.sqrt(dim)+1;
		for (i=2; i<dim1; i++) {    
			if (bEsPrimer[i]) 
				{
				// Eliminar els múltiples de i
				int mult = 2*i;
				for (j=mult; j<dim; j+=i)    
					bEsPrimer[j] = false; 
				} 
			}
	}

	
    public static void main (String args[]) {
        System.out.println("Generació de nombres primers amb Garbell d'Erastòtenes:");
        System.out.println("-------------------------------------------------------");
        int[] VectorFinalPrimers;
        VectorFinalPrimers = obtenirPrimers (120);
        System.out.println(VectorFinalPrimers.length + " nombres primers trobats en el interval [1-120]");
        System.out.println(Arrays.toString(VectorFinalPrimers));
    }
	
}
	        
	        


