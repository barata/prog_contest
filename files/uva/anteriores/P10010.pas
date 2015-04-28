{ @BEGIN_OF_SOURCE_CODE }
{ @JUDGE_ID: 39715JC 10010 PASCAL "" }

program Waldorf;

type
  mat = array[1..50, 1..50] of Char;

procedure procura(matriz: mat; m, n: ShortInt; palavra: String; direcao: Char; var L, C: ShortInt);
var
  cont,
  posL, posC,
  a, b,
  len,
  LI, LF, CI, CF: ShortInt;
  ok: Boolean;
begin
  len := Length(palavra);
  { ajustando os limites de busca de acordo com a direcao }
  case direcao of
    '1': begin
           LI := len;
           LF := m;
           CI := len;
           CF := n;
         end;
    '2': begin
           LI := len;
           LF := m;
           CI := 1;
           CF := n;
         end;
    '3': begin
           LI := len;
           LF := m;
           CI := 1;
           CF := n - len + 1;
         end;
    '4': begin
           LI := 1;
           LF := m;
           CI := 1;
           CF := n - len + 1;
         end;
    '5': begin
           LI := 1;
           LF := m - len + 1;
           CI := 1;
           CF := n - len + 1;
         end;
    '6': begin
           LI := 1;
           LF := m - len + 1;
           CI := 1;
           CF := n;
         end;
    '7': begin
           LI := 1;
           LF := m - len + 1;
           CI := len;
           CF := n;
         end;
    '8': begin
           LI := 1;
           LF := m;
           CI := len;
           CF := n;
         end;
  end;
  { percorrendo os espacos possiveis }
  for a := LI to LF do
    for b := CI to CF do begin
      cont := 1;
      posL := a;
      posC := b;
      { testando se a primeira letra eh igual }
      ok := palavra[cont] = matriz[posL, posC];
      { se for, compara as restantes }
      while ok and (cont < len) do begin
        { dependendo da direcao... segue um caminha diferente }
        if (direcao = '1') or (direcao = '2') or (direcao = '3') then Dec(posL);
        if (direcao = '3') or (direcao = '4') or (direcao = '5') then Inc(posC);
        if (direcao = '5') or (direcao = '6') or (direcao = '7') then Inc(posL);
        if (direcao = '7') or (direcao = '8') or (direcao = '1') then Dec(posC);
        { adianta a letra que sera comparada }
        Inc(cont);
        ok := palavra[cont] = matriz[posL, posC];
      end;
      { se achar testa se eh mais a esquerda que o anterior }
      if ok then begin
        { atualizando resultados }
        if a < L then begin
          L := a;
          C := b;
        end
        else if a = L then
          if b < C then C := b;
      end;
    end;
end;

var
  n_testes, cont: Integer;
  a, b, { contadores }
  m, n, { linha e coluna }
  respL, respC, auxL, auxC,
  n_palavras: ShortInt;
  palavra: String[50];
  matriz: mat;
  achou: Boolean;

BEGIN
  readln(n_testes);

  for cont := 1 to n_testes do begin
    readln; { lendo a linha em branco }
    readln(m, n);

    { carrega matriz }
    for a := 1 to m do begin
      for b := 1 to n do begin
        read(matriz[a, b]);
        matriz[a, b] := UpCase(matriz[a, b]);
      end;
      readln;
    end;

    { lendo as palavras que serao procuradas }
    readln(n_palavras);
    for a := 1 to n_palavras do begin
      readln(palavra);
      { converte para maiusculo }
      for b := 1 to Length(palavra) do
        palavra[b] := UpCase(palavra[b]);
      { procurando palavra }
      respL := m;
      respC := n;
      procura(matriz, m, n, palavra, '1', respL, respC);
      procura(matriz, m, n, palavra, '2', respL, respC);
      procura(matriz, m, n, palavra, '3', respL, respC);
      procura(matriz, m, n, palavra, '4', respL, respC);
      procura(matriz, m, n, palavra, '5', respL, respC);
      procura(matriz, m, n, palavra, '6', respL, respC);
      procura(matriz, m, n, palavra, '7', respL, respC);
      procura(matriz, m, n, palavra, '8', respL, respC);
      { resultado }
      writeln(respL, ' ', respC);
    end;
    { imprime linha de espacamento }
    if cont < n_testes then writeln;
  end;
END.
{ @END_OF_SOURCE_CODE }