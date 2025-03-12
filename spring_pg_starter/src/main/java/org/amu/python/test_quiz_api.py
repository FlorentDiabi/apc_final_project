import requests
import json


BASE_URL = "http://localhost:8080/quizzes"

# Test GET all quizzes
def test_get_all_quizzes():
    response = requests.get(BASE_URL)
    if response.status_code == 200:
        print("GET /quizzes - Success:", response.json())
    else:
        print("GET /quizzes - Failed:", response.status_code)

# Test GET quiz by ID
def test_get_quiz_by_id(quiz_id):
    response = requests.get(f"{BASE_URL}/get/{quiz_id}")
    if response.status_code == 200:
        print(f"GET /quizzes/get/{quiz_id} - Success:", response.json())
    else:
        print(f"GET /quizzes/get/{quiz_id} - Failed:", response.status_code)

# Test POST create quiz
def test_create_quiz(title):
    quiz_data = {
        "title": title,
        "questions": []
    }
    response = requests.post(f"{BASE_URL}/new", json=quiz_data)
    if response.status_code == 201:
        print("POST /quizzes/new - Success:", response.json())
    else:
        print("POST /quizzes/new - Failed:", response.status_code)

# Test PUT update quiz
def test_update_quiz(quiz_id, title):
    quiz_data = {
        "title": title,
        "questions": []
    }
    response = requests.put(f"{BASE_URL}/update/{quiz_id}", json=quiz_data)
    if response.status_code == 200:
        print(f"PUT /quizzes/update/{quiz_id} - Success:", response.json())
    else:
        print(f"PUT /quizzes/update/{quiz_id} - Failed:", response.status_code)

# Test DELETE quiz
def test_delete_quiz(quiz_id):
    response = requests.delete(f"{BASE_URL}/delete/{quiz_id}")
    if response.status_code == 200:
        print(f"DELETE /quizzes/delete/{quiz_id} - Success")
    elif response.status_code == 404:
        print(f"DELETE /quizzes/delete/{quiz_id} - Not Found")
    else:
        print(f"DELETE /quizzes/delete/{quiz_id} - Failed:", response.status_code)

if __name__ == "__main__":
    # Test les différentes routes API
    print("Testing GET all quizzes:")
    test_get_all_quizzes()


    print("\nTesting GET quiz by ID:")
    test_get_quiz_by_id(1)

    print("\nTesting POST create quiz:")
    test_create_quiz("New Quiz")


    print("\nTesting PUT update quiz:")
    test_update_quiz(1, "Updated Quiz Title")


    print("\nTesting DELETE quiz:")
    test_delete_quiz(1)
