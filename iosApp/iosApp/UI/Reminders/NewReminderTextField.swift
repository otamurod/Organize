//
//  NewReminderTextField.swift
//  iosApp
//
//  Created by Otamurod Safarov on 20/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct NewReminderTextField: View {
    @Binding var text: String
    var onSubmit: () -> Void

    var body: some View {
        TextField(
            "Add new reminder here",
            text: $text
        ).onSubmit {
            onSubmit()
        }
    }
}

struct NewReminderTextField_Previews: PreviewProvider {
    static var previews: some View {
        NewReminderTextField(text: .constant("")) {}
    }
}
