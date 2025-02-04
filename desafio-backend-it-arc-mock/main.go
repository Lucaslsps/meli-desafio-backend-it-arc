package main

import (
	"fmt"
	"net/http"
)

func main() {
	http.HandleFunc("/mock", func(w http.ResponseWriter, r *http.Request) {
		if r.Method == http.MethodPost {
			fmt.Fprintf(w, "ok")
		} else {
			http.Error(w, "Method not allowed", http.StatusMethodNotAllowed)
		}
	})

	http.ListenAndServe(":8082", nil)
}
