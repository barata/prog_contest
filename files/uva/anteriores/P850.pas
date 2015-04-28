{ @BEGIN_OF_SOURCE_CODE }
{ @JUDGE_ID: 39715JC 850 PASCAL "" }

program Crypt2;

const
  COMP: String[43] = 'the quick brown fox jumps over the lazy dog';

type
  frase = String[80];
  texto = array[1..100] of frase;
  trad = array['a'..'z'] of Char;

procedure IniTrad(var Tradutor: trad);
var
  cont: Char;
begin
  for cont := 'a' to 'z' do
    Tradutor[cont] := #0;
end;

procedure ProximoCompativel(conj: texto; var indice: ShortInt; total: ShortInt);
  { funcao que retorna True se for compativel com o tradutor }
  function EhCompativel(T: frase): Boolean;
  var
    cont: ShortInt;
    temp: Boolean;
  begin
    temp := True;
    cont := 1;
    while (cont <= Length(T)) and temp do begin
      if (T[cont] in ['a'..'z']) xor (COMP[cont] in ['a'..'z']) then
        temp := False;
      Inc(cont);
    end;
    EhCompativel := temp and (Length(T) = Length(COMP));
  end;
  { fim da funcao }
var
  aux: Boolean;
begin
  repeat
    Inc(indice);
    aux := EhCompativel(conj[indice]);
  until aux or (indice >= total);
  { caso nao encontre uma frase compativel, retorna -1 }
  if not aux then indice := -1;
end;

{ VARIAVEIS GLOBAIS }
var
  k, n_testes: Word;
  conjunto: texto;
  x, y, indice, n_frases: ShortInt;
  tradutor: trad;

BEGIN
  readln(n_testes);

  for k := 1 to n_testes do begin
    readln; { lendo a linha em branco }

    n_frases := 0;
    { carregando o texto }
    while not Eoln do begin
      Inc(n_frases);
      readln(conjunto[n_frases]);
    end;

    indice := 0;
    { procurando a proxima frase que serah o tradutor }
    ProximoCompativel(conjunto, indice, n_frases);

    { verificando se ha solucao }
    if indice > 0 then begin
      { montando tradutor }
      x := 1;
      IniTrad(tradutor);
      while (x <= Length(conjunto[indice])) and (indice > 0) do begin
        if tradutor[conjunto[indice, x]] = #0 then
          tradutor[conjunto[indice, x]] := COMP[x]
        else if tradutor[conjunto[indice, x]] <> COMP[x] then begin
          ProximoCompativel(conjunto, indice, n_frases);
          IniTrad(tradutor);
          x := 0;
        end;
        Inc(x);
      end;

      { imprimindo resultados }
      if indice > 0 then
        for x := 1 to n_frases do begin
          for y := 1 to Length(conjunto[x]) do
            write(tradutor[conjunto[x, y]]);
          writeln;
        end
      else writeln('No solution.');
    end
    else writeln('No solution.');

    { imprimindo linha em branco }
    if k < n_testes then writeln;
  end;
END.
{ @END_OF_SOURCE_CODE }