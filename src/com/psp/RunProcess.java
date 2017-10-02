package com.psp;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Arrays;

public class RunProcess {

	public static void main(String[] args) {
		// La clase recibe como parámetro el nombre del proceso a lanzar desde la máquina virtual
		if(args.length <= 0) {
			System.err.println("Falta el nombre del ejecutable");
			System.exit(-1);
		}
		
		ProcessBuilder pb = new ProcessBuilder();
		
		String pid;
		pid = ManagementFactory.getRuntimeMXBean().getName();
		
		System.out.println("El PID del padre es " + pid);
	
		try {
			Process proceso = pb.start();
			int retorno = proceso.waitFor();
			System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + retorno);
			
		} catch (IOException e) {
			System.err.println("Excepción de E/S");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("Proceso interrumpido");
			e.printStackTrace();
		}
	}

}
