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
				System.out.println("Quantos albuns deseja consultar? (caso todos digite -1)");
				int quantidade = in.nextInt();
				in.nextLine();
				if (quantidade == -1) {
					System.out.println("Consulta sendo processada...");
				} else {
					System.out.println("Digite o nome de cada álbum que deseja consultar seguido por um enter");
					String[] nomes = new String[quantidade];
					for(int i = 0; i < quantidade; i++) {
						nomes[i] = in.nextLine();
					}
					System.out.println("Consulta sendo processada...");
				}

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
