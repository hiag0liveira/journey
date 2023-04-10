// Selecionando os campos de entrada e o botão de envio
const inputNome = document.getElementById('floatingInputNome');
const inputTelefone = document.getElementById('floatingInputTelefone');
const inputEmail = document.getElementById('floatingInputEmail');
const inputTipo = document.getElementById('floatingSelectTipo');
const inputCpf = document.getElementById('floatingInputCpf');
const inputCnpj = document.getElementById('floatingInputCnpj');
const submitButton = document.getElementById('submitButton');

const campoCpf = document.getElementById('campoCpf');
const campoCnpj = document.getElementById('campoCnpj');

// Adicionando um ouvinte de eventos para cada campo de entrada
inputNome.addEventListener('input', checarInput);
inputTelefone.addEventListener('input', checarInput);
inputEmail.addEventListener('input', checarInput);
inputTipo.addEventListener('input', checarInput);
inputCpf.addEventListener('input', checarInput);
inputCnpj.addEventListener('input', checarInput);

// Checa se foi escolhido pessoa fisica ou juridica
inputTipo.addEventListener('change', checarTipo)

// Mascaras de input
inputCpf.addEventListener('keypress', mascararCpf);
inputCnpj.addEventListener('keypress', mascararCnpj);
inputTelefone.addEventListener('keypress', mascararTel);

// Função para verificar se todos os campos estão preenchidos
function checarInput() {
    if (
        inputNome.value !== '' &&
        inputTelefone.value !== '' &&
        inputEmail.value !== '' &&
        (inputCpf.value !== '' || inputCnpj.value !== '') &&
        (inputTipo.value === 'PessoaFisica' || inputTipo.value === 'PessoaJuridica')
    ){
        submitButton.disabled = false;
    }
    else {
        submitButton.disabled = true;
    }
}

function checarTipo(){
    if (inputTipo.value === 'PessoaFisica') {
        campoCnpj.style.display = 'none';
        campoCpf.style.display = 'block';
    }
    else if (inputTipo.value === 'PessoaJuridica') {
        campoCnpj.style.display = 'block';
        campoCpf.style.display = 'none';
    }
    else {
        campoCnpj.style.display = 'none';
        campoCpf.style.display = 'none';
    }
}

function mascararCpf(){
    console.log(inputCpf.value.length)
    if (inputCpf.value.length === 3 || inputCpf.value.length === 7){
        inputCpf.value += '.';
    }
    else if(inputCpf.value.length === 11) {
        inputCpf.value += '-';
    }
}

function mascararCnpj(){
    console.log(inputCnpj.value.length)
    if (inputCnpj.value.length === 2 || inputCnpj.value.length === 6){
        inputCnpj.value += '.';
    }
    else if(inputCnpj.value.length === 10) {
        inputCnpj.value += '/';
    }
    else if(inputCnpj.value.length === 15) {
        inputCnpj.value += '-';
    }
}

function mascararTel(){
    console.log(inputTelefone.value.length)
    if (inputTelefone.value.length === 0){
        inputTelefone.value += '('
    }
    else if (inputTelefone.value.length === 3){
        inputTelefone.value += ') '
    }
    else if (inputTelefone.value.length === 10){
        inputTelefone.value += '-'
    }
}
