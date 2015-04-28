{ @BEGIN_OF_SOURCE_CODE }
{ @JUDGE_ID: 39715JC 10205 PASCAL "" }

program Stack;

var
  i, a, b,
  n_testes, n_shuffles, acao: ShortInt;
  deck, deck_aux: array[1..52] of ShortInt;
  shuffles: array[1..100, 1..52] of ShortInt;
  nomes: array[1..52] of String;

BEGIN
  { inicializando o deck }
  for b := 1 to 4 do
    for a := 1 to 13 do begin
      case a of
        1: nomes[a + (b - 1) * 13] := '2 of ';
        2: nomes[a + (b - 1) * 13] := '3 of ';
        3: nomes[a + (b - 1) * 13] := '4 of ';
        4: nomes[a + (b - 1) * 13] := '5 of ';
        5: nomes[a + (b - 1) * 13] := '6 of ';
        6: nomes[a + (b - 1) * 13] := '7 of ';
        7: nomes[a + (b - 1) * 13] := '8 of ';
        8: nomes[a + (b - 1) * 13] := '9 of ';
        9: nomes[a + (b - 1) * 13] := '10 of ';
        10: nomes[a + (b - 1) * 13] := 'Jack of ';
        11: nomes[a + (b - 1) * 13] := 'Queen of ';
        12: nomes[a + (b - 1) * 13] := 'King of ';
        13: nomes[a + (b - 1) * 13] := 'Ace of ';
      end;
      case b of
        1: nomes[a + (b - 1) * 13] := nomes[a + (b - 1) * 13] + 'Clubs';
        2: nomes[a + (b - 1) * 13] := nomes[a + (b - 1) * 13] + 'Diamonds';
        3: nomes[a + (b - 1) * 13] := nomes[a + (b - 1) * 13] + 'Hearts';
        4: nomes[a + (b - 1) * 13] := nomes[a + (b - 1) * 13] + 'Spades';
      end;
    end;

  { lendo o numero de testes }
  readln(n_testes);
  { processando o numero de testes }
  for i := 1 to n_testes do begin
    { inicializa o deck }
    for a := 1 to 52 do
      deck[a] := a;
    { leitura da linha vazia }
    readln;
    { leitura do numero de shuffles }
    readln(n_shuffles);
    { carregando os shuffles na matriz }
    for a := 1 to n_shuffles do begin
      for b := 1 to 52 do
	read(shuffles[a, b]);
      readln;
    end;
    { verificando qual shuffle realizar }
    while not Eoln do begin
      readln(acao);
      { montando o baralho auxiliar }
      for a := 1 to 52 do
	deck_aux[a] := deck[shuffles[acao, a]];
      { transferindo mudancas para o deck }
      for b := 1 to 52 do
        deck[b] := deck_aux[b];
    end;
    { pulando uma linha }
    if i > 1 then writeln;
    { impressao do resultado }
    for a := 1 to 52 do
      writeln(nomes[deck[a]]);
  end;
END.
{ @END_OF_SOURCE_CODE }