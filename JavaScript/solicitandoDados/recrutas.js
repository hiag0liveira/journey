const primeiroNome = prompt("Informe o primeiro nome do recruta:")
const sobrenome = prompt("Informe o sobrenome do recruta:")
const campoDeEstudo = prompt("Qual é o campo de estudo do recruta?")
const anoDeNascimento = prompt("Qual é o ano de nascimento do recruta?")

alert(
  "Recruta cadastrado com sucesso!\n" +
  "\nNome completo: " + primeiroNome + " " + sobrenome +
  "\nCampo de estudo: " + campoDeEstudo +
  "\nIdade: " + (2022 - anoDeNascimento)
)

