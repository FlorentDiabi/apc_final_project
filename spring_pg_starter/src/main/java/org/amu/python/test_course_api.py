import requests
import json

BASE_URL = "http://localhost:8080"

# Test GET /courses
def test_get_all_courses():
    response = requests.get(f"{BASE_URL}/courses")
    if response.status_code == 200:
        print("Test GET /courses: Success")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"Test GET /courses failed with status code {response.status_code}")

# Test GET /courses/get/{id}
def test_get_course_by_id(course_id):
    response = requests.get(f"{BASE_URL}/courses/get/{course_id}")
    if response.status_code == 200:
        print(f"Test GET /courses/get/{course_id}: Success")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"Test GET /courses/get/{course_id} failed with status code {response.status_code}")

# Test POST /courses/new
def test_create_course():
    course_data = {
        "title": "Advanced Python Programming"
    }
    response = requests.post(f"{BASE_URL}/courses/new", json=course_data)
    if response.status_code == 201:
        print("Test POST /courses/new: Success")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"Test POST /courses/new failed with status code {response.status_code}")

# Test PUT /courses/get/{id}
def test_update_course(course_id):
    updated_course_data = {
        "title": "Advanced Python Programming - Updated"
    }
    response = requests.put(f"{BASE_URL}/courses/get/{course_id}", json=updated_course_data)
    if response.status_code == 200:
        print(f"Test PUT /courses/get/{course_id}: Success")
        print(json.dumps(response.json(), indent=2))
    else:
        print(f"Test PUT /courses/get/{course_id} failed with status code {response.status_code}")

# Test DELETE /courses/delete/{id}
def test_delete_course(course_id):
    response = requests.delete(f"{BASE_URL}/courses/delete/{course_id}")
    if response.status_code == 200:
        print(f"Test DELETE /courses/delete/{course_id}: Success")
    else:
        print(f"Test DELETE /courses/delete/{course_id} failed with status code {response.status_code}")

if __name__ == "__main__":
    # Teste chaque méthode
    test_get_all_courses()
    test_get_course_by_id(1)
    test_create_course()
    test_update_course(1)
    test_delete_course(1)
