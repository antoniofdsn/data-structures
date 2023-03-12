import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PilhaeFila {

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<Integer>();

        // Passo 1: inserindo os números [1, 2, 3, 4 e 5] na lista
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        // Passo 2: removendo os dados da lista e inserindo na pilha
        Stack<Integer> pilha = new Stack<>();
        while (!lista.isEmpty()) {
            pilha.push(lista.removeLast());
        }

        // Passo 3: removendo os dados da pilha e inserindo na fila
        Queue<Integer> fila = new LinkedList<Integer>();
        while (!pilha.isEmpty()) {
            fila.offer(pilha.pop());
        }

        // Passo 4: inserindo os números [6, 7, 8, 9 e 10] na lista
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(9);
        lista.add(10);

        // Passo 5: repetindo os passos 2 e 3
        while (!lista.isEmpty()) {
            // removendo os dados da lista e inserindo na pilha
            while (!lista.isEmpty()) {
                pilha.push(lista.removeLast());
            }

            // removendo os dados da pilha e inserindo na fila
            while (!pilha.isEmpty()) {
                fila.offer(pilha.pop());
            }
        }

        // Passo 6: exibindo todos os números que foram inseridos na fila
        while (!fila.isEmpty()) {
            System.out.print(fila.poll() + " ");
        }
    }
}

// A justificativa para a ordem dos números exibidos é que, a pilha e a fila
// seguem a lógica LIFO (Last-In-First-Out) e FIFO (First-In-First-Out),
// respectivamente. Portanto, a ordem final dos números exibidos na fila será 1
// 2 3 4 5 6 7 8 9 10.
