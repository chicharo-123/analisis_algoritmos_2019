#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>


int Rabin (char cad1[], char cad2[]){
int hashA=0, hashB=0;
int i, band=0;
int j=0;
    for(i=0; i< strlen(cad2); i++){
    hashA+=cad1[i]*pow(2, i);
    hashB+=cad2[i]*pow(2, i);
    }
    for(i=0; i<strlen(cad1)-strlen(cad2)+1; i++){
    if(hashA==hashB){

	for(j; j<strlen(cad2); j++){
    if(cad1[i+j]==cad2[j])
    band++;
    else{
    j=strlen(cad2);
    band=0;
	}
    }
    if(band==strlen(cad2))
    return 1;
        }
        hashA = ((hashA - cad1[i])/2) +
		 (cad1[i+strlen(cad2)]*pow(2, strlen(cad2)-1));
    }

    return 0;
}
int main()
{
    char cad1[20] = {'c','h','i','c','a','r','o',' ','c','h','i','c','h','a','r','o','\0'};
    char cad2[10] = {'c','h','i','c','h','a','r','o','\0'};
    if(Rabin(cad1, cad2)==1)
    printf("se encontro la palabra\n");
    else
    printf("no se encontro la palabra\n");
    return 0;
}
