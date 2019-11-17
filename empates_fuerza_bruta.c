//#include<iostream>
#include <conio.h>
#include<string.h>
#include<time.h>
#include<stdio.h>
 
#define maxPatron 50
#define maxTexto 500
 
 //using namespace std;
 
void FuerzaBruta(char [],char [], int, int); //declaramos la funcion FuerzaBruta
 
int main(void)
{
//system("color 0a");
char Texto[maxTexto];
char Patron[maxPatron];
float Tiempo,inicio,fin;
int n,m;

 
printf("ingrese la cadena\n");

gets(Texto);
n=strlen(Texto);
do{ 
	printf("ingrese la subcadena a buscar\n");

  gets(Patron);

    m=strlen(Patron);
    if( m > n )
    printf("la cadena debe ser mas grande que la subcadena\n");

    }while(m>n); //validamos que el patron sea menor que el texto
 
inicio=clock();                  //inicio del tiempo
FuerzaBruta(Texto,Patron,n,m);   //llamamos a la funcion FuerzaBruta
fin=clock();                     //captura el tiempo realizado hasta esta linea
Tiempo=((fin-inicio)/CLOCKS_PER_SEC);//calculamos el tiempo

 
getch();
return 0;
 
}

 
void FuerzaBruta(char texto[],char patron[], int n, int m)
{ int i,j,k, cont=0;
  char temp[100];
  for(i=0; i<=n;i++)
    { for(j=i,k=0;j<m;j++,k++)
      temp[k]=texto[i+k];
      temp[k]='\0';
      if(strcmp(patron,temp)==0)
         {
		 printf("empatamiento en la pocicion %i\n",i);
		 
         cont++;}
         m++;
      }
      printf("aparecio estas veces %i\n",cont);
 }

