.data
CARTEIRA:
 .word 300
.text
 lw $a0, CARTEIRA
 li $a1, 12 # Meses de cálculo
 li $a2, 1000 # Valor do salário
 li $a3, 437 # Imposto mensal bruto
 jal COMPUTA_SALARIO # Chama a rotina do salario
 sw $v0, CARTEIRA
# Nossa rotina de salários
COMPUTA_SALARIO:
 add $a0, $a0, $a2 # Soma salario com carteira
 sub $a0, $a0, $a3 # Subtrai os impostos
 addi $a1, $a1, -1 # decrementa um mês
 bne $a1, $zero, COMPUTA_SALARIO
 add $v0, $a0, $zero # Copia o resultado para retorno
 jr $ra # Retorna após o "jal"