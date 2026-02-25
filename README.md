# Cálculo de Pi com Threads — Série de Leibniz (Java)
Este projeto demonstra na prática como o paralelismo reduz o tempo de processamento em tarefas de alto desempenho. Através da implementação e comparação de desempenho entre execução sequencial e concorrente no cálculo numérico da constante Pi de acordo com a Série de Leibniz, utilizando Java com suporte nativo a threads.

---

## Resultados do Desempenho

Cálculo realizado com 2 bilhões de termos da Série de Leibniz:

| Execução | Tempo | Threads |
|---|---|---|
| Sequencial | ~4,86 segundos | 1 |
| Concorrente | ~1,42 segundos | 4 |
| **Otimização** | **~3,4x mais rápido** | — |

> O valor de Pi obtido em ambas as execuções foi idêntico: **3,1415926531**,
> validando que a divisão de tarefas entre threads não comprometeu a precisão matemática.

---

## Como executar

**1. Clone o repositório**
```bash
git clone https://github.com/RodiNeves12/leibniz-threads-java.git
cd leibniz-threads-java
```

**2. Compilar**
```bash
javac ProgramaSequencial.java
javac ProgramaConcorrente.java
```

**3. Executar**
```bash
# Versão sequencial
java ProgramaSequencial

# Versão concorrente
java ProgramaConcorrente
```

---
