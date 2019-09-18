package laboral;

public class CalculaNominas {

	public static void main(String[] args) {

		
		try {
			Empleado e1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
			Empleado e2 = new Empleado("Ada Lovelace", "32000031R", '1');
			
			System.out.println(escribe(e1, e2));
		} catch (DatosNoCorrectosException e) {
			System.out.println(e);
		}
		
	}
	
	private static String escribe (Empleado emp1, Empleado emp2) {
		return emp1.toString() + "\n" + emp2.toString();
	}

}
