.data
CARTEIRA : 
     .word 300
.text
   li $a0, 12    # Meses de cálculo 
COMPUTA_SALARIO:
   lw $t0, CARTEIRA
   li $t1, 1000  #Salario
 add  $t2, $t0, $t1 
   li $t0, 447   # Valor dos impostos
 sub  $t2, $t2 ,$t0
  sw  $t2, CARTEIRA

addi  $a0, $a0, -1
 bne  $a0, $zero, COMPUTA_SALARIO