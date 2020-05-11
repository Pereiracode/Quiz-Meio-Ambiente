package data;

import models.Pergunta;

public class Data {
    public String[] listRespostaEasy = {
    "Rio de Janeiro", "Espírito Santo", "Bahia", "Tocantins",
    "Proteção da intervenção humana", "Prevalecer os interesses econômicos", "Intervenção humana no ambiente", "Nenhuma das alternativas", 
    "Homem e a natureza", "Homem e a máquina", "Natureza e a máquina", "Natureza e a industria",
    "Espaços naturais protegidos por lei", "Espaços protegidos por índios", "Espaços industriais", "Nenhuma das alternativas",
    "Queimada", "Legislação", "Reciclagem", "Chuva ácida",
    "Amazônia", "Pampa", "Cerrado", "Caatinga",
    "5 de Junho", "11 de Setembro", "23 de Maio", "6 de Fevereiro"
    };
    
    Pergunta p1 = new Pergunta("Qual estado com maior número de parques e reservas ambientais no Brasil?", listRespostaEasy[0]);
    Pergunta p2 = new Pergunta("Preservação ambiental é ...", listRespostaEasy[4]);
    Pergunta p3 = new Pergunta("Conservação Ambiental é a harmonia do ...", listRespostaEasy[8]);
    Pergunta p4 = new Pergunta("O que são unidades de conservação?", listRespostaEasy[12]);
    Pergunta p5 = new Pergunta("Qual o principal problema ambiental do Brasil?", listRespostaEasy[16]);
    Pergunta p6 = new Pergunta("Considerado o maior Bioma brasileiro e a maior reserva de diversidade biológica do mundo", listRespostaEasy[20]);
    Pergunta p7 = new Pergunta("O dia mundial do meio ambiente é:", listRespostaEasy[24]);
    
    public Pergunta[] listPerguntaEasy = {p1, p2, p3, p4, p5, p6, p7};
    
    public String[] listRespostaMedium = {
    "Conjunto de elementos físicos, químicos, biológicos e sociais que podem causar efeitos sobre os seres vivos", "Conjunto de elementos psicossociais legislados pelo governo", "Biodiversidade de qualquer organização de iniciativa privada", "Território pertencente a industria",
    "Atmosfera, hidrosfera, litosfera e biosfera", "Hidrosfera, biosfera, clima e atmosfera", "Atmosfera, biosfera, metano e hidrosfera", "Hidrosfera, gás carbônico, atmosfera e biosfera", 
    "Meteorologia", "Climatologia", "Mecânica dos gases", "Astrologia",
    "Fertilizante químico", "Rotação de Cultura", "Adubação orgânica", "Terraceamento",
    "Construção de casas sustentáveis, que sejam preparadas com uso de energias alternativas e renováveis", "Juntar os lixos em saco único para ser mais facilmente manipulado", "Aumentar o consumo de produtos industrializados", "Proteger todo tipo de poluição nas águas dos rios, mares, oceanos e lagos",
    "Diminuição de áreas verdes na cidade", "Melhorar o sistema de transporte coletivo", "Diminuir o número de carros nas ruas", "Manutenção de veículos automotores",
    "Poluição Sonora", "Poluição Ruidosa", "Poluição Sonífera", "Poluição Atmosférica"
    };
    
    Pergunta p8 = new Pergunta("Para a ONU - Organização das Nações Unidas, meio ambiente é ...", listRespostaMedium[0]);
    Pergunta p9 = new Pergunta("O meio ambiente é composto por quais esferas?", listRespostaMedium[4]);
    Pergunta p10 = new Pergunta("Qual o nome da ciência que estuda as condições atmosféricas?", listRespostaMedium[8]);
    Pergunta p11 = new Pergunta("No mundo há várias técnicas no sistema de cultivo no uso do solo sem afetar a sua contaminação exceto:", listRespostaMedium[12]);
    Pergunta p12 = new Pergunta("Quais são medidas de sustentabilidade para preservar o  meio ambiente?", listRespostaMedium[16]);
    Pergunta p13 = new Pergunta("<html>A poluição atmosférica prejudica a nossa saúde com doenças respiratórias. Marque a única alternativa que não relata uma forma de diminuirmos esse tipo de poluição:", listRespostaMedium[20]);
    Pergunta p14 = new Pergunta("<html>Temos vários tipos de poluição que prejudicam o meio ambiente. Algumas poluições são pouco lembradas, como o caso da poluição desencadeada quando o volume de determinado som é maior que o regular, com base na análise do texto, qual o nome da poluição referida?", listRespostaMedium[24]);
    
    public Pergunta[] listPerguntaMedium = {p8, p9, p10, p11, p12, p13, p14};
    
    public String[] listRespostaHard = {
    "Capivara", "Tamanduá Bandeira", "Onça Pintada", "Gato Maracujá",
    "125 hectares", "699 hectares", "500 hectares", "12 hectares", 
    "2008", "2005", "2007", "2001",
    "Desenvolvimento com o meio ambiente", "Sustentar o meio ambiente em detrimento do desenvolvimento", "Garantir o desenvolvimento contemporâneo ", "Sustentar a necessidade do desenvolvimento",
    "Compostagem de resíduos alimentares", "Reação do solo", "Produção de adubos químicos", "Reaproveitamento de Cálcio e Fosfato",
    "Ecossistemas", "Sistemas", "Fatores Bióticos", "Fatores Abióticos",
    "Unidirecional e decrescente", "Unidirecional e crescente", "Bidirecional e crescente", "Bidirecional e decrescente"
    };
    
    Pergunta p15 = new Pergunta("Qual destes animais não estão sobre risco de extinção?", listRespostaHard[0]);
    Pergunta p16 = new Pergunta("<html>A Amazônia é uma das maiores reservas ambientas do mundo. Em 2019 houveram muitos focos de queimada, cerca de 89 mil registrados, cerca de 30% a mais que 2018, com base nos seus conhecimentos quantos hectares foram queimados na Amazônia em 2019?", listRespostaHard[4]);
    Pergunta p17 = new Pergunta("Qual ano que tivemos o maior índice de desmatamento na Amazônia?", listRespostaHard[8]);
    Pergunta p18 = new Pergunta("<html>A destruição ambiental é um processo de desenvolvimento industrial que começa a ter mudança a partir de um novo conceito: O DESENVOLVIMENTO SUSTENTÁVEL. Como definir essa expressão?", listRespostaHard[12]);
    Pergunta p19 = new Pergunta("<html>O reaproveitamento de resíduos orgânicos é benéfico para quem pratica a adubação. Dado o fato, com esses reaproveitamentos orgânicos caseiros, estamos destacando o processo de:", listRespostaHard[16]);
    Pergunta p20 = new Pergunta("Qual o objeto de estudo da Ecologia?", listRespostaHard[20]);
    Pergunta p21 = new Pergunta("O fluxo de matéria nas cadeias alimentares é", listRespostaHard[24]);
    
    public Pergunta[] listPerguntaHard = {p15, p16, p17, p18, p19, p20, p21};
    
    public Data(){
    }
}
