package estruturas;

public class ListaCharacter {

    static final int QUANTIDADE_LISTA = 2;

    Character[] lista = new Character[QUANTIDADE_LISTA];
    int tamanho = 0;

    //Metodo para adicionar elemento na lista
    public void adicionar(Character valor) {

        if (tamanho == lista.length) {
            Character[] novaLista = new Character[QUANTIDADE_LISTA + lista.length]; //soma a quantidade inicial mais a atual

            for (int i = 0; i < lista.length; i++) {
                novaLista[i] = lista[i];
            }

            lista = novaLista; // adiciona na lista a nova lista com um tamanho maior

        }

        lista[tamanho] = valor;

        tamanho++;

    }

    //Metodo para obter um valor da lista
    public Character obter(int index) {

        return lista[index];

    }

    //Metodo para obter o tamanho da lista
    public int tamanhoLista() {

        return tamanho;

    }

    //Metodo para remover um elemento da lista
    public void remover(Character valor) {

        for (int i = 0; i < tamanho; i++) {
            Character a = lista[i];

            if (a != null && a.equals(valor)) {
                remover(i);
                break;
            } else if (a == null && valor == null) {

                remover(i);
                break;

            }

        }

    }

    private void remover(int index) {

        int indexInicial = index + 1;

        for (int i = indexInicial; i < tamanho; i++) {

            lista[i - 1] = lista[i];

        }

        tamanho--;
        lista[tamanho] = null;
    }

    //Metodo para exibir toda  a lista
    public void mostrar() {

        for (int i = 0; i < tamanho; i++) {

            Character a = obter(i);
            if (a != null) {
                System.out.println("Aluno: " + a);
            } else {
                System.out.println("");
            }

        }

    }

}
