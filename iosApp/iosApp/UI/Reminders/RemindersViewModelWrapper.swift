//
//  RemindersViewModelWrapper.swift
//  iosApp
//
//  Created by Otamurod Safarov on 20/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Combine
import Shared

final class RemindersViewModelWrapper: ObservableObject {
    let viewModel = RemindersViewModel()

    @Published private(set) var reminders: [Reminder] = []

    init() {
        viewModel.onRemindersUpdated = { [weak self] items in // using [weak self] breaks a potential memory cycle
            self?.reminders = items
        }
    }
}
