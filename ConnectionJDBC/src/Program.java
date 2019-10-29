import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Negocio jdbc = new Negocio();
		Scanner in = new Scanner(System.in);
		int cmd = 1;
		while (cmd != 0) {
			if(cmd < 0 || cmd > 4) System.out.println("Nao consegui compreender, por favor tente novamente.");
			System.out.println("Por favor defina a opera��o que deseja realizar:");
			System.out.println("0 - Para fechar o programa");
			System.out.println("1 - Inserir");
			System.out.println("2 - Remover");
			System.out.println("3 - Consultar");
			cmd = Integer.parseInt(in.nextLine());
		}
		switch (cmd) {
			case 0:
				System.out.println("bye");
				break;
			case 1:
				System.out.println("Selecione em qual tabela voce deseja inserir um dado:");
				System.out.println("0 - Usu�rio");
				System.out.println("1 - M�sica");
				System.out.println("2 - Artista");
				System.out.println("3 - Playlist");
				cmd = Integer.parseInt(in.nextLine());
				if (cmd == 0) {
					
				} else if (cmd == 1) {
					
				} else if (cmd == 2) {
					
				} else if (cmd == 3) {
					
				} else {
					
				}
			case 2:
				System.out.println("Selecione de qual tabela voce deseja remover um dado:");
				System.out.println("0 - Usu�rio");
				System.out.println("1 - M�sica");
				System.out.println("2 - Artista");
				System.out.println("3 - Playlist");
				cmd = Integer.parseInt(in.nextLine());
				if(cmd == 0) {
					
				} else if (cmd == 1) {
					
				} else if (cmd == 2) {
					
				} else if (cmd == 3) {
					
				}
			case 3:
				System.out.println("Selecione em qual tabela voce deseja fazer uma consulta");
				System.out.println("0 - Usu�rio");
				System.out.println("1 - M�sica");
				System.out.println("2 - Artista");
				System.out.println("3 - Playlist");
				cmd = Integer.parseInt(in.nextLine());
				String[] attributes = [10];
				int len = 0;
				if (cmd == 0) {
					System.out.println("Selecione quais atributos você deseja visualizar, respondendo com 's' ou 'n'");
					System.out.println("nome");
					cmd = in.nextLine();
					if (cmd == 's') {
						attributes[len] = "nome";
						len += 1;
					}
					System.out.println("email");
					cmd = in.nextLine();
					if (cmd == 's') {
						attributes[len] = "email";
						len += 1;
					}
					System.out.println("idade");
					cmd = in.nextLine();
					if (cmd == 's') {
						attributes[len] = "idade";
						len += 1;
					}
					String[len] values;
					for (int i = 0; i < len; i++) {
						values[i] = attributes[i];
					}
					System.out.println("Você deseja selecionar algum usuário com uma condição específica? (s ou n)");
					cmd = in.nextLine();
					if (cmd == "s") {
						System.out.println("Através de qual atributo?");
						System.out.println("0 - idade");
						System.out.println("1 - nome");
						System.out.println("2 - email");
						cmd = in.nextLine();
						switch (cmd) {
							case '0':
								System.out.println("Qual idade?");
								cmd = in.nextLine();
								jdbc.onSELECT(values, "USUARIO", ["idade"], [cmd]);
								break;
							case '1':
								System.out.println("Qual nome?");
								cmd = in.nextLine();
								jdbc.onSELECT(values, "USUARIO", ["nome"], [cmd]);
								break;
							case '2':
								System.out.println("Qual email?");
								cmd = in.nextLine();
								jdbc.onSELECT(values, "USUARIO", ["email"], [cmd]);
								break;
						}
					}
				} else if (cmd == 1) {

				} else if (cmd == 2) {

				} else if (cmd == 3) {

				}
		}
		jdbc.closeConnection();
	}

}
