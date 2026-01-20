
# 🏫 Sistema de Gestão Escolar – Alunos, Turmas e Boletins

Este projeto foi desenvolvido como solução para o Desafio Técnico da StralooHealth: [Sistema de Gestão Escolar (Nível Estágio).](https://github.com/straloohealth/TesteTecnico-NivelEstagio2026.1)

O objetivo é implementar um sistema centralizado capaz de gerenciar alunos, turmas e notas, além de consolidar essas informações para gerar o boletim escolar de um aluno.

---
📌 Visão Geral

A aplicação consiste em um único serviço backend, responsável por:

- Cadastro e listagem de Turmas
- Cadastro e listagem de Alunos
- Registro de Notas por disciplina
- Geração do Boletim Escolar de um aluno (média e status)

A aplicação expõe uma API REST, retornando dados no formato JSON.

## 🏗 Stack 
O projeto segue o padrão **MVC (Model–View–Controller)**, aplicado ao contexto de APIs REST.

- **Linguagem e framework:** Java 21 (Spring Boot)
- **Banco de dados:** PostgreSQL
- **Containerização**: Docker + Docker Compose

---

## 📦 Modelos de Dados (Objetos)

### 🎓 Student
```
{
  "id": 1,
  "name": "João Silva",
  "age": 15,
  "classroomId": 1,
  "registration": "REG-001"
 }   
```

### 📚 Classroom 
```
{
  "id": 1,
  "name": "1º Ano A"
}
```

### 📚 Grade 
```
{
    "id": 1,
    "studentId": 1,
    "studentName": "João Silva",
    "subject": "Matemática",
    "value": 7.50
}
```

### 📚 ReportCard 
```
{
    "id": "3cc2d69f-a413-4ef4-a82c-aed866c530e5",
    "studentName": "João Silva",
    "studentId": 1,
    "studentClassroomId": 1,
    "grades": [
        {
            "id": 1,
            "studentId": 1,
            "studentName": "João Silva",
            "subject": "Matemática",
            "value": 7.50
        },
        {
            "id": 2,
            "studentId": 1,
            "studentName": "João Silva",
            "subject": "Português",
            "value": 6.00
        },
        {
            "id": 3,
            "studentId": 1,
            "studentName": "João Silva",
            "subject": "História",
            "value": 8.00
        }
    ],
    "average": 7.17,
    "status": "APPROVED"
}
```

## Requisitos Funcionais
- Listar Turmas: Retornar todas as turmas cadastradas ( GET /api/classrooms )
```
[
    {
        "id": 1,
        "name": "1º Ano A"
    },
    {
        "id": 2,
        "name": "1º Ano B"
    },
    {
        "id": 3,
        "name": "2º Ano A"
    }
]
```
- Listar Alunos de uma Turma: Dado o identificador de uma turma, retornar a lista de alunos vinculados. ( GET /api/students?classroomId={id} )
```
[
    {
        "id": 1,
        "name": "João Silva",
        "age": 15,
        "classroomId": 1,
        "registration": "REG-001"
    },
    {
        "id": 2,
        "name": "Maria Oliveira",
        "age": 14,
        "classroomId": 1,
        "registration": "REG-002"
    }
]
```
- Gerar Boletim de um aluno (exibindo dados do aluno, turma, disciplinas e notas). ( GET /api/report-cards/{studentId} )
```
{
    "id": "8851b8bd-3ab6-4947-b16e-c30c29f35fc3",
    "studentName": "João Silva",
    "studentId": 1,
    "studentClassroomId": 1,
    "grades": [
        {
            "id": 1,
            "studentId": 1,
            "studentName": "João Silva",
            "subject": "Matemática",
            "value": 7.50
        },
        {
            "id": 2,
            "studentId": 1,
            "studentName": "João Silva",
            "subject": "Português",
            "value": 6.00
        },
        {
            "id": 3,
            "studentId": 1,
            "studentName": "João Silva",
            "subject": "História",
            "value": 8.00
        }
    ],
    "average": 7.17,
    "status": "APPROVED"
}
```

## 🎓 Student Controller
| Método | Endpoint             | Descrição             |
| ------ | -------------------- | --------------------- |
| GET    | `/api/students`      | Lista todos os alunos |
| GET    | `/api/students/{id}` | Busca aluno por ID    |
| GET    | `/api/students?classroomId={id}` | Busca aluno por identificador da turma    | 
| POST   | `/api/students`      | Cria um novo aluno    |
| DELETE | `/api/students/{id}` | Remove um aluno       |

## 📚 Classroom Controller
| Método | Endpoint               | Descrição             |
| ------ | ---------------------- | --------------------- |
| GET    | `/api/classrooms`      | Lista todas as turmas |
| GET    | `/api/classrooms/{id}` | Busca turma por ID    |
| POST   | `/api/classrooms`      | Cria uma nova turma   |
| DELETE | `/api/classrooms/{id}` | Remove uma turma      |

## 🎓 Grade Controller
| Método | Endpoint                                       | Descrição                                      |
| ------ | ---------------------------------------------- | ---------------------------------------------- |
| GET    | `/api/grades/{studentId}`                      | Retorna todas as notas de um aluno             |
| POST   | `/api/grades`                                  | Registra uma nova nota                         |

## 📚 ReportCard Controller
| Método | Endpoint                        | Descrição                         |
| ------ | ------------------------------- | --------------------------------- |
| GET    | `/api/report-cards/{studentId}` | Gera e retorna o boletim do aluno |

## 🚀 Instalação

### 1️⃣ Clone o repositório
```
git clone https://github.com/2Rovian/api-gestao-escolar
```

### 2️⃣ Acesse o diretório

```
cd api-gestao-escolar/
```

### 3️⃣ Rode os containers

```
docker-compose up --build
```

## 🔌 Ports
http://localhost:8080  
