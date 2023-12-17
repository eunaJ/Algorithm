def solution(my_string, queries):
    answer = my_string
    for s,e in queries:
        a = answer[s:e+1]
        a = a[::-1]
        answer = answer[:s]+a+answer[e+1:]
    return answer