import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Negocio jdbc = new Negocio();
		Scanner in = new Scanner(System.in);
		int cmd = 1;
		while (cmd != 0) {
			if(cmd < 0 || cmd > 4) System.out.println("Não consegui compreender, por favor tente novamente.");
			System.out.println("Por favor defina a operação que deseja realizar:");
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
				System.out.println("0 - Usuário");
				System.out.println("1 - Música");
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
				System.out.println("0 - Usuário");
				System.out.println("1 - Música");
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
				System.out.println("0 - Usuário");
				System.out.println("1 - Música");
				System.out.println("2 - Artista");
				System.out.println("3 - Playlist");
				cmd = Integer.parseInt(in.nextLine());
		}
		jdbc.closeConnection();
	}

}
