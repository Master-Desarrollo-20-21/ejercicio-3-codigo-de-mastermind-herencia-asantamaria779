package mastermind;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console
{

	public void out (String salida)
	{
		System.out.print(salida);
	}	

public String readString(String mensaje)
{
	String entrada = null;
	System.out.print(mensaje);

	try 
	{
		entrada = b.readLine();
	}
	catch (Exception e) 
	{		
		this.exit();		
	}
	return entrada;
}

private void exit()
{
	System.out.println("ERROR de entrada/salida");
	System.exit(0);
}

private static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

}