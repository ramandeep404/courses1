#include<stdio.h>
int checkprime(int a)
{
int i;
for(i=2;i<=a/2;i++)
{
if(a%i==0)
{
prime=0;
break;
}
}
if(prime==1)
{
printf(“Number is prime”);
}
else
{
printf(“Number is not prime”);
}
int main()
{
int a;
int prime=0;
printf(“\nEnter a number”);
scanf(“%d”,&a);
prime=checkprime(a);
if(a==1)
{
printf(“Number is prime”);
}
else
{
printf(“Number is not prime”);
}
return 1;
}