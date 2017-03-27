from math import sqrt

query = 20

def is_prime(n):
	return all(n % i for i in range(2,n))
def primes(q):
	return [i for i in range(2,q) if is_prime(i)]
def find_starting(p):
	num = 1
	for i in p:
		num *= i
	return num

query = find_starting(primes(query))

def does_divide(q, d):
	for i in range(d,0,-1):
		if q % i == 0:
			continue
		else:
			return False
	return True

while not does_divide(query, 20):
	query +=2

print(query)