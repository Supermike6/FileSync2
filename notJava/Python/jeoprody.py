import requests as req

questions=req.get('https://jservice.io/api/clues?value=100&min_date=1985-02-20').json()
print(questions)

# for i in range(0,10):
#     print(f"question {i}:"+questions[i]["question"])