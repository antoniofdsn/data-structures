import java.util.Scanner;

public class CadastroAlunos {

    private static final int NUM_ALUNOS_INICIAL = 25;
    private static final int NUM_ALUNOS_ADICIONAIS = 5;
    private static final String REGEX_NOME = "^[\\p{L}\\s]+$";

    public static void main(String[] args) {

        // criando array para armazenar os nomes dos alunos
        String[] nomesAlunos = new String[NUM_ALUNOS_INICIAL + NUM_ALUNOS_ADICIONAIS];

        Scanner sc = new Scanner(System.in);

        // preenchendo o array com os nomes dos alunos
        for (int i = 0; i < NUM_ALUNOS_INICIAL; i++) {
            System.out.print("Digite o nome do " + (i + 1) + "º aluno: ");
            nomesAlunos[i] = validarNome(sc.nextLine());
        }

        // adicionando mais 5 alunos
        int posicao = NUM_ALUNOS_INICIAL;
        for (int i = 0; i < NUM_ALUNOS_ADICIONAIS; i++) {
            System.out.print("Digite o nome do " + (i + 26) + "º aluno: ");
            nomesAlunos[posicao] = validarNome(sc.nextLine());
            posicao++;
        }

        sc.close();

        // imprimindo os nomes dos alunos cadastrados
        System.out.println("Alunos cadastrados:");
        for (int i = 0; i < nomesAlunos.length; i++) {
            System.out.println((i + 1) + "º aluno: " + nomesAlunos[i]);
        }
    }

    private static String validarNome(String nome) {
        while (nome.isEmpty() || !nome.matches(REGEX_NOME)) {
            if (nome.isEmpty()) {
                System.out.println("Por favor, digite um nome válido.");
            } else {
                char caractereInvalido = nome.charAt(nome.replaceAll(REGEX_NOME, "").length());
                System.out.println("Por favor, remova o caractere inválido \"" + caractereInvalido + "\" do nome.");
            }
            nome = new Scanner(System.in).nextLine();
        }
        return nome;
    }
}
