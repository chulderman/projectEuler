F = [1, 1]
i = 2
x = 0

while x <= 4000000:
	x = F[i-2]+F[i-1]
	F.append(x)
	i += 1

print sum([x for x in F if x % 2 == 0])