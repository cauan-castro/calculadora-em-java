import java.util.Scanner; //importa a biblioteca necessária para receber os dados que o usuário digita
// função calcular
public class calculadora {
    public static float calcular(Scanner teclado) { //função do tipo float para aceitar números decímais

        //Pergunta ao usuário qual operação ele deseja realizar
        System.out.println("Escolha o operador matemático que deseja usar.");
        System.out.println("Digite 1 para adição");
        System.out.println("Digite 2 para subtração");
        System.out.println("Digite 3 para multiplicação");
        System.out.println("Digite 4 para divisão");
        int operacao = teclado.nextInt(); //recebi o dado digitado pelo usuário e armazena em uma variável do tipo int

        // pede ao usuário digitar um número e armazena na variável "num1" que significa "1º número"
        System.out.print("Digite o primeiro número: ");
        float num1 = teclado.nextFloat();

        //pede ao usuário digitar um número e armazena na variável "num2" que significa "2º número" 
        System.out.print("Digite o segundo número: ");
        float num2 = teclado.nextFloat();

        //defini uma variavel do tipo float para armazenar o resultado da operação
        float resultado = 0;
        //estrutura caso para realizar a operação que o usuário pediu
        switch (operacao) {
            //caso o usuário digite 1, é realizado a soma dos números
            case 1:                         
                resultado = num1 + num2;
                break;
            //caso o usuário digite 2, é realizado a subtração dos números
            case 2:                         
                resultado = num1 - num2;
                break;
            //caso o usuário digite 3, é realizado a multiplicação dos números
            case 3:                         
                resultado = num1 * num2;
                break;
            //caso o usuário digite 4, é realizado a divisão dos números
            case 4:                         
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Erro: Divisão por zero!"); //respondi com um erro se o usuário digitar 0 no 2º número
                    return Float.NaN;
                }
                break;
            //se o usuário digitar um algo que não um número, então isso será mostrado na tela do usuário
            default:                        
                System.out.println("Operação inválida!");   
                return Float.NaN;
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Cria o Scanner para ler as entradas digitadas pelo usuário no terminal.
        Scanner teclado = new Scanner(System.in);

        // Controla se o programa deve continuar realizando novos cálculos.
        boolean continuar = true;
        // Executa o bloco de cálculo enquanto o usuário escolher continuar.
        while (continuar) {
            // Chama a função calcular para executar uma operação matemática completa.
            float resultado = calcular(teclado);
            // Exibe o resultado apenas quando a operação foi válida.
            if (!Float.isNaN(resultado)) {
                System.out.printf("O resultado é: %.2f\n", resultado);
            }

            // Pergunta ao usuário se ele deseja fazer outro cálculo.
            System.out.print("Quer continuar calculando? (s/n): ");
            // Lê a resposta e remove espaços extras no início/fim.
            String resposta = teclado.next().trim();
            // Continua o loop somente se a resposta for "s" (maiúsculo ou minúsculo).
            continuar = resposta.equalsIgnoreCase("s");
        }

        // Fecha o Scanner ao finalizar o programa para liberar o recurso.
        teclado.close();
    }    
}
