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
			System.out.println("1 - Consultar");
			System.out.println("2 - Inserir");
			System.out.println("3 - Remover");
			cmd = Integer.parseInt(in.nextLine());
			switch (cmd) {
			case 0:
				System.out.println("bye bye!");
				break;
			case 1:
				System.out.println("Vamos realizar a consulta juntos!");
				boolean notOk = true;
				do {
					System.out.println("Digite quantos atributos deseja retornar (1 caso '*'):");
					int interations = Integer.parseInt(in.nextLine());
					String [] attributes = new String [interations];
					System.out.println("Digite os atributos, um por vez (após enter):");
					for (int i=0; i<interations; i++) {
						attributes[i] = in.nextLine();
					}
					System.out.println("A consulta até agora está: ");
					System.out.print("SELECT ");
					if(interations == 1) {
						System.out.println(attributes[0]);
					}else {
						for(int i=0; i<interations-1; i++) {
							System.out.print(attributes[i] + ", ");
						}
						System.out.println(attributes[interations-1]);
					}
					System.out.println("Está correto?(y/n): ");
					String resp = in.nextLine();
					if(resp.contains("n")) {
						System.out.println("Vamos novamente");
					}else {
						notOk = false;
					}
				}while(notOk);

				break;
			case 2:
				break;
			case 3:
				break;
			}
		}
		jdbc.closeConnection();
	}

}
