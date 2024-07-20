//
//  ReminderItem.swift
//  iosApp
//
//  Created by Otamurod Safarov on 20/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ReminderItem: View {
    let title: String
    let isCompleted: Bool

    var body: some View {
        HStack {
            Image(
                systemName: isCompleted ? "largecircle.fill.circle" : "circle"
            )
            .imageScale(.large)
            .foregroundStyle(
                isCompleted ? AnyShapeStyle(.tint) : AnyShapeStyle(.secondary)
            )
            Text(title)
                .font(.body)
                .strikethrough(isCompleted, color: nil)
                .foregroundStyle(
                    isCompleted ? .secondary : .primary
                )
            Spacer()
        }
        .contentShape(Rectangle())
    }
}

struct ReminderItem_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            ReminderItem(title: "New Item", isCompleted: false)
            ReminderItem(title: "Done Item", isCompleted: true)
        }
    }
}
