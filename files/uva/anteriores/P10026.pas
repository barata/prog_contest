{ @BEGIN_OF_SOURCE_CODE }
{ @JUDGE_ID: 39715JC 10026 PASCAL "" }

program Shoemaker;

var
  a, i, j,
  n_testes, N,
  dias, custo: Integer;
  mat: array[1..1001, 1..3] of Integer;

BEGIN
  readln(n_testes);

  for a := 1 to n_testes do begin
    { le a linha em branco }
    readln;

    { le o numero de casos }
    readln(N);
    for i := 1 to N do begin
      { armazena a numero da linha }
      mat[i, 1] := i;
      { le o numero de dias e o custo }
      readln(mat[i, 2], mat[i, 3]);
    end;

    { ordenando }
    for i := 2 to N do
      for j := N downto i do
        if mat[j - 1, 3] / mat[j - 1, 2] < mat[j, 3] / mat[j, 2] then begin
          mat[1001] := mat[j - 1];
          mat[j - 1] := mat[j];
          mat[j] := mat[1001];
        end;

    { imprime resultado }
    for i := 1 to N do begin
      write(mat[i, 1]);
      if i <> N then write(' ')
      else writeln;
    end;

    { imprime o espaco entre dois casos }
    if a <> n_testes then writeln;
  end;
END.
{ @END_OF_SOURCE_CODE }