import requests
import json


BASE_URL = "http://localhost:8080/exams"

# 1. Test GET all exams
def test_get_all_exams():
    response = requests.get(BASE_URL)
    if response.status_code == 200:
        print("GET all exams success:")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"GET all exams failed with status code {response.status_code}")

# 2. Test GET exam by ID
def test_get_exam_by_id(exam_id):
    response = requests.get(f"{BASE_URL}/get/{exam_id}")
    if response.status_code == 200:
        print(f"GET exam by ID ({exam_id}) success:")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"GET exam by ID failed with status code {response.status_code}")

# 3. Test POST create new exam
def test_create_exam():
    new_exam = {
        "title": "Maths Exam - Spring 2025",
        "user": {
            "id": 1
        },
        "students": [
            {"id": 2},
            {"id": 3}
        ]
    }
    headers = {'Content-Type': 'application/json'}
    response = requests.post(f"{BASE_URL}/new", data=json.dumps(new_exam), headers=headers)
    if response.status_code == 200:
        print("POST create exam success:")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"POST create exam failed with status code {response.status_code}")

# 4. Test PUT update exam
def test_update_exam(exam_id):
    updated_exam = {
        "title": "Updated Maths Exam - Spring 2025",
        "user": {
            "id": 1  # L'ID de l'enseignant
        },
        "students": [
            {"id": 2},
            {"id": 3}
        ]
    }
    headers = {'Content-Type': 'application/json'}
    response = requests.put(f"{BASE_URL}/get/{exam_id}", data=json.dumps(updated_exam), headers=headers)
    if response.status_code == 200:
        print(f"PUT update exam ({exam_id}) success:")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"PUT update exam failed with status code {response.status_code}")

# 5. Test DELETE delete exam
def test_delete_exam(exam_id):
    response = requests.delete(f"{BASE_URL}/delete/{exam_id}")
    if response.status_code == 204:
        print(f"DELETE exam ({exam_id}) success")
    else:
        print(f"DELETE exam failed with status code {response.status_code}")

# Exemple d'utilisation
if __name__ == "__main__":
    # Test 1: Get all exams
    test_get_all_exams()

    # Test 2: Get exam by ID (pass un ID d'examen existant)
    test_get_exam_by_id(1)

    # Test 3: Create new exam
    test_create_exam()

    # Test 4: Update exam (pass un ID existant pour mettre à jour)
    test_update_exam(1)

    # Test 5: Delete exam (pass un ID existant pour supprimer)
    test_delete_exam(1)
