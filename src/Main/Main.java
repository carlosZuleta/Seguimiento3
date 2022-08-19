package Main;

import java.util.*;
import Model.*;


public class Main {

	public static void main(String[] args) {
		
		   Banco banco = new Banco();
		
	       Scanner sn = new Scanner(System.in);
	       
	       int x = 0;
	       while(x!= 6){
	    	   System.out.println("");
	    	   System.out.println(" ");
	           System.out.println("----------------Bienvenido--------------");
	           System.out.println("-----------------Eliga una opcion------------------------");
	           System.out.println("1. agreagar turno ");
	           System.out.println("2. Dar Turno");
	           System.out.println("3. Mostrar Turno Actual");
	           System.out.println("4. Pasar turno");
	           System.out.println("5. Eliminar turno actual y seguir ");
	           System.out.println("6. cerrar todo");
	            
	           System.out.println("Escribe una de las opciones: ");
	           x = sn.nextInt();
	           
	           Nodo turnoactual = banco.getTurnoActual();
		       switch(x) {
		       		
		       		case 1:
		       			
		       			banco.agregarNuevoTurno();
		                System.out.println("El turno aniadido es: "+(banco.getNewTurno()-1));
		            break;
		       		case 2:
				
		       			if (turnoactual!=null){
	                        banco.eliminar();
	                        System.out.println("Se le dio el turno a: "+turnoactual.getTurno());
	                        System.out.println("Se elimino al turno: "+turnoactual.getTurno()+" ya que fue atendido");
	                        turnoactual = banco.getTurnoActual();
	                        if (turnoactual!=null){
	                            System.out.println("El nuevo turno es: "+turnoactual.getTurno());
	                        } else {
	                            System.out.println("Esta era la ultima persona en la fila, por lo que la lista quedo vacia");
	                        }

	                    } else {
	                        System.out.println("No se puede dar paso a nadie ya que la lista esta vacia");
	                    }
	                break;
		       		case 3:
		                if (turnoactual!=null){
		                    System.out.println("el turno actual es: "+turnoactual.getTurno());
		                } else {
		                    System.out.println("no se puede mostrar turnos, ya que no existe nadie en la cola");
		                }
		                break;
		       		case 4:
	                    if (turnoactual!=null){
	                        banco.pasarTurno();
	                        System.out.println("Se paso el turno: "+turnoactual.getTurno());
	                        int pasadas = turnoactual.getVecesPasadas();
	                        System.out.println("Se ha pasado un total de "+pasadas+" veces");
	                        if (pasadas==3){
	                            System.out.println("Al pasar un total de 3 veces se elimino el turno");
	                            if (turnoactual.getNext().equals(turnoactual)){
	                                System.out.println("La lista quedo vacia");
	                            } else {
	                                System.out.println("El nuevo turno es: "+turnoactual.getNext().getTurno());
	                            }
	                        } else{
	                            System.out.println("El nuevo turno es: "+turnoactual.getNext().getTurno());
	                        }
	                    }else {
	                        System.out.println("No existe nadie en la lista");
	                    }

	                break;
		       		case 5:
	                    if (turnoactual!=null){
	                        System.out.println("Se elimino el turno: "+turnoactual.getTurno());
	                        turnoactual = banco.getTurnoActual();

	                        banco.eliminar();
	                    } else{
	                        System.out.println("No se puede eliminar a nadie ya que la lista esta vacia");

	                    }
	                break;
	                    
		       		case 6: 
	                    break;
	                default: System.out.println("ingrese una opcion correcta");
		       
		       
		       
		       }
	          
	           
	            
	       }
	      
	        
	    }
	
	

	}

