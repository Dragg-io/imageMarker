## API de Marca d'Água

Esta API permite que os usuários enviem uma imagem codificada em Base64 e apliquem uma marca d'água personalizada a ela. As configurações da marca d'água, como texto, posição, cor e tamanho da fonte, podem ser definidas pelo usuário.


## Endpoints
### Adicionar Marca d'Água
- URL: /api/images/watermark
- Método: POST
- Descrição: Adiciona uma marca d'água a uma imagem enviada pelo usuário.
- Content-Type: application/json

```json
{
    "image": "iVBORw0KGgoAAAANSUhEUgAA...",
    "markConfig": {
        "text": "Marca d'água",
        "posX": 100,
        "posY": 150,
        "color": "#FFFFFF",
        "fontSize": 40
    }
}
```

- Parâmetros:
  - image (string): A imagem codificada em Base64.
  - markConfig (objeto): As configurações da marca d'água.
    - text (string): O texto da marca d'água.
    - posX (int): A posição X da marca d'água na imagem.
    - posY (int): A posição Y da marca d'água na imagem.
    - color (string): A cor da marca d'água em formato hexadecimal (por exemplo, "#FFFFFF" para branco).
    - fontSize (int): O tamanho da fonte do texto da marca d'água.

## Resposta

### Código 200 OK
```json
{
    "image": "iVBORw0KGgoAAAANSUhEUgAA..."
}
```

### Código 400 BAD REQUEST
```json
{
  "error": "Invalid Base64 input: ..."
}
```

### Código 500 INTERNAL SERVER ERROR
```json
{
  "error": "Error processing image"
}
```

## Exemplo de uso
### Requisição
```bash
curl -X POST http://localhost:8080/api/images/watermark \
-H "Content-Type: application/json" \
-d '{
    "image": "iVBORw0KGgoAAAANSUhEUgAA...",
    "markConfig": {
        "text": "Marca d'água",
        "posX": 100,
        "posY": 150,
        "color": "#FFFFFF",
        "fontSize": 40
    }
}'
```

### Resposta
```json
{
    "image": "iVBORw0KGgoAAAANSUhEUgAA..."
}
```

## Configuração e Execução
### Pré-requisitos
- Java 17
- Maven

### Como Executar
1. Clone o repositório:
```bash
git clone https://github.com/Dragg-io/imageMarker.git
cd imageMarker
```
2. Compile e execute o projeto:
```bash
mvn clean install
mvn spring-boot:run
```