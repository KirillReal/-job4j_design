package ru.job4j.ood.lsp;

public class AccountExample {
    private int capital;

    AccountExample(int sum) throws Exception {
        if (sum < 100) {
            throw new Exception("Некорректная сумма");
        }
        this.capital = sum;
    }

    public void setCapital(int money) throws Exception {
        if (money < 0) {
            throw new Exception("Нельзя положить на счет меньше 0");
        }
    }

    public double getInterest(double sum,  int month, int rate) throws Exception {
        // предусловие
        if (sum < 0 || month > 12 || month < 1 || rate < 0) {
            throw new Exception("Некорректные данные");
        }

        double result = sum;
        for (int i = 0; i < month; i++) {
            result += result * rate / 100;
        }

        // постусловие
        if (sum >= 1000) {
            result += 100;
        }
        return result;
    }

    public int capital(int value) throws Exception {
        value = getCapital();
            if (value < 100) {
                throw new Exception("Некорректная сумма");
            }
            capital = value;

        return value;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapitals(int capital) {
        this.capital = capital;
    }

}

class MicroAccount extends AccountExample {

    MicroAccount(int sum) throws Exception {
        super(sum);
    }


    // Подкласс MicroAccount добавляет дополнительное предусловие,
    // то есть усиливает его, что недопустимо
    @Override
    public  void setCapital(int money) throws Exception {
        if (money < 0) {
            throw new Exception("Нельзя положить на счет меньше 0");
        }

        if (money > 100) {
            throw new Exception("Нельзя положить на счет больше 100");
        }

    }

    //Исходя из логики класса Account, в методе CalculateInterest мы ожидаем получить в
    // качестве результата числа 1200.
    // Однако логика класса MicroAccount показывает другой результат.
    // В итоге мы приходим к нарушению принципа Лисков -
    // Постусловия не могут быть ослаблены в подклассе
    @Override
    public double getInterest(double sum, int month, int rate) throws Exception {
        if (sum < 0 || month > 12 || month < 1 || rate < 0) {
            throw new Exception("Некорректные данные");
        }

        double result = sum;
        for (int i = 0; i < month; i++) {
            result += result * rate / 100;
        }

        return result;
    }
    //С точки зрения класса Account поле не может быть меньше 100,
    // и в обоих случаях, где идет присвоение - в конструкторе и свойстве это гарантируется.
    // А вот производный класс MicroAccount, переопределяя свойство Capital,
    // этого уже не гарантирует.

    // Поэтому инвариант класса Account нарушается
    @Override
    public int capital(int value) {
        value = getCapital();

        return value;
    }
}
