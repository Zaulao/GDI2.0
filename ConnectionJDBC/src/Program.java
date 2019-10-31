import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Negocio jdbc = new Negocio();
		Scanner in = new Scanner(System.in);
		int cmd = 1;
		while (cmd != 0) {
			if(cmd < 0 || cmd > 4) System.out.println("Nao consegui compreender, por favor tente novamente.");
			System.out.println("Por favor defina a operacao que deseja realizar:");
			System.out.println("0 - Para fechar o programa");
			System.out.println("1 - Inserir");
			System.out.println("2 - Remover");
			System.out.println("3 - Consultar");
			cmd = Integer.parseInt(in.nextLine());
		}
		switch (cmd) {
			case 0:
				System.out.println("bye bye!");
				break;
			case 1:
				System.out.println("Vamos realizar a consulta juntos!");
				boolean notOk = true;
				do {
					
				}while(notOk);
				
				break;
			case 2:
				break;
			case 3:
				break;
		}
		jdbc.closeConnection();
	}

}
