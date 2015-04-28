const
	maxn = 10000;
var
	list : array[1 .. maxn] of integer;
	l,n : integer;

procedure get_primes;
var
	ck : array[1 .. maxn] of boolean;
	i,j : integer;
begin
	fillchar(ck, sizeof(ck), true);
	for i := 2 to 100 do
		if ck[i] then begin
			j := i * i;
			while j <= maxn do begin
				ck[j] := false;
				j := j + i;
			end;
		end;
	for i := 2 to maxn do
		if ck[i] then begin
			inc(l);
			list[l] := i;
		end
end;

procedure show( a, b : integer);
begin
	if a + b = 0 then
		writeln(n, ' is not the sum of two primes!')
	else
		writeln(n, ' is the sum of ', a, ' and ', b, '.')
end;

function be_prime( x : integer) : boolean;
var i,j : integer;
begin
	j := trunc(sqrt(x));
	be_prime := false;
	if x = 1 then exit;
	for i := 2 to l do
		if list[i] > j then break
		else if x mod list[i] = 0 then exit;
	be_prime := true;
end;

procedure check_odd;
begin
	if n = 1 then show(0, 0)
	else if be_prime(n - 2) then show(2, n - 2)
	else show(0, 0);
end;

procedure check_even;
var i,j : integer;
begin
	if n = 2 then show(0, 0)
	else begin
		j := n div 2; i := n - j; { keep i > j }
		if i = j then begin dec(j); inc(i); end;
		if not odd(j) and not odd(i) then begin dec(j); inc(i); end;
		repeat
			if be_prime(j) then
			if be_prime(i) then begin show(j, i); exit; end;
			j := j - 2;
			i := i + 2;
		until j <= 0;
		show(0, 0);
	end;
end;

begin
	get_primes;

	while not eof do begin
		readln(n);
		if odd(n) then check_odd
		else check_even;
	end;

end.
