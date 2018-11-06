.data
CARTEIRA : 
     .word 300
.text 
   lw $t0, CARTEIRA
   li $t1, 1000  #Salario
 add  $t2, $t0, $t1 
   li $t0, 447   # Valor dos impostos
 sub  $t2, $t2 ,$t0  