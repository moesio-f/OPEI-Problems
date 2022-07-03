#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {
  stack<int> s;
  string str;

  getline(cin, str);

  for (char c : str) {
    if (c == '{') {
      s.push('a');
    } else if (c == '}') {
      if (s.empty()) {
        cout << "N\n";
        return 0;
      }

      s.pop();
    }
  }

  if (s.empty()) {
    cout << "S\n";
  } else {
    cout << "N\n";
  }

  return 0;
}