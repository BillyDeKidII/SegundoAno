.data
CARTEIRA : 
     .word 300
.text 
   lw $t0, CARTEIRA
   li $t1, 1000  #Salario
 add  $t2, $t0, $t1 