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
				String[] nomes = new String[quantidade];
				if (quantidade == -1) {
					jdbc.onSELECT("Album", nomes);
				} else {
					System.out.println("Digite o nome de cada álbum que deseja consultar seguido por um enter");
					for(int i = 0; i < quantidade; i++) {
						nomes[i] = in.nextLine();
					}
					jdbc.onSELECT("Album", nomes);
				}

				break;
			case 2:
				String[] attributes = new String[3];
				String[] values = new String[3];
				attributes[0] = "nome";
				attributes[1] = "ano_lancamento";
				attributes[2] = "capa";
				System.out.println("Vamos inserir um novo álbum juntos!");
				System.out.println("Digite o nome do álbum");
				values[0] = in.nextLine();
				System.out.println("Digite o ano de lançamento");
				values[1] = in.nextLine();
				System.out.println("Adicione a capa do álbum à pasta FilesToInsert");
				System.out.println("Digite o nome da imagem que você inseriu");
				values[2] = in.nextLine();
				System.out.println("Inserção sendo realizada...");
				jdbc.onINSERT(values);
				break;
			case 3:
				System.out.println("Qual o nome do álbum que você deseja excluir?");
				String nome = in.nextLine();
				if (nome.contains("JESUS IS KING")) {
					System.out.println("Nosso programa não comete blasfêmia.");
				} else {
					jdbc.onDELETE("Album", "nome", nome);
				}
				break;
			}
		}
		jdbc.closeConnection();
	}

}
