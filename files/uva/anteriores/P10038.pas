{ @BEGIN_OF_SOURCE_CODE }
{ @JUDGE_ID: 39715JC 10038 PASCAL "" }

program Jolly;

var
  n,
  i, j: Integer;
  elemento, final: array[1..3000] of LongInt;
  temp: LongInt;
  result: Boolean;

BEGIN
  while not EOF do begin
    read(n);

    for i := 1 to n do begin
      read(elemento[i]);
      if (i > 1) then
        final[i - 1] := Abs(elemento[i] - elemento[i - 1]);
    end;
    readln;

    for i := 2 to n do
      for j := n - 1 downto i do
	if (final[j - 1] > final[j]) then begin
	  temp := final[j - 1];
	  final[j - 1] := final[j];
	  final[j] := temp;
	end;

    result := True;
    if (n > 1) then
      for i := 1 to n - 1 do
	if (final[i] <> i) then begin
	  result := False;
	  break;
	end;

    if (result) then
      writeln('Jolly')
    else
      writeln('Not jolly');
  end;
END.
{ @END_OF_SOURCE_CODE }