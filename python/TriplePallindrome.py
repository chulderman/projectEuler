i = 999
j = 999
floor = 0
pal = 0

while i != floor:
	while j != floor:
		k = i*j
		if str(k) == str(k)[::-1]:
			if (pal < k):
				pal = k
				floor = pal/i;
				break
		j-=1
	i -= 1
	j = 999
	
print(pal)