import requests
import json


BASE_URL = "http://localhost:8080/questions"

# Fonction pour obtenir toutes les questions
def get_all_questions():
    response = requests.get(BASE_URL)
    if response.status_code == 200:
        print("All Questions:", response.json())
    else:
        print("Failed to get questions. Status code:", response.status_code)

# Fonction pour obtenir une question par ID
def get_question_by_id(question_id):
    response = requests.get(f"{BASE_URL}/get/{question_id}")
    if response.status_code == 200:
        print(f"Question {question_id}:", response.json())
    else:
        print(f"Failed to get question {question_id}. Status code:", response.status_code)

# Fonction pour créer une nouvelle question
def create_question():
    # Exemple de question à créer
    new_question = {
        "questionTitle": "What is the capital of France?",
        "category": "Geography",
        "difficultyLevel": "Medium",
        "option1": "Paris",
        "option2": "Berlin",
        "option3": "Madrid",
        "option4": "Rome",
        "rightAnswer": "Paris"
    }
    response = requests.post(f"{BASE_URL}/new", json=new_question)
    if response.status_code == 200:
        print("Created Question:", response.json())
    else:
        print("Failed to create question. Status code:", response.status_code)

# Fonction pour mettre à jour une question existante
def update_question(question_id):
    # Exemple de question mise à jour
    updated_question = {
        "questionTitle": "What is the capital of Germany?",
        "category": "Geography",
        "difficultyLevel": "Medium",
        "option1": "Paris",
        "option2": "Berlin",
        "option3": "Madrid",
        "option4": "Rome",
        "rightAnswer": "Berlin"
    }
    response = requests.put(f"{BASE_URL}/update/{question_id}", json=updated_question)
    if response.status_code == 200:
        print(f"Updated Question {question_id}:", response.json())
    else:
        print(f"Failed to update question {question_id}. Status code:", response.status_code)

# Fonction pour supprimer une question
def delete_question(question_id):
    response = requests.delete(f"{BASE_URL}/delete/{question_id}")
    if response.status_code == 204:
        print(f"Deleted Question {question_id}")
    else:
        print(f"Failed to delete question {question_id}. Status code:", response.status_code)

# Exemple d'utilisation
if __name__ == "__main__":
    print("Testing API Endpoints\n")

    # 1. Obtenir toutes les questions
    get_all_questions()

    # 2. Obtenir une question par son ID (par exemple, ID = 1)
    get_question_by_id(1)

    # 3. Créer une nouvelle question
    create_question()

    # 4. Mettre à jour une question existante (par exemple, ID = 1)
    update_question(1)

    # 5. Supprimer une question (par exemple, ID = 1)
    delete_question(1)
